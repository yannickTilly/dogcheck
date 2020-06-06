package meyti.dogcheck.Service;

import io.lettuce.core.api.sync.RedisCommands;
import meyti.dogcheck.Model.RedisObject.User;
import meyti.dogcheck.Service.RedisConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;

@Service
public class RedisMap {

    @Autowired
    private RedisConnector redisConnector;

    public List<User> getUsers(float latitude, float longitude)
    {
        List<Coordinates> zones = getAroundZone(getZone(latitude, longitude));
        List<User> users = new ArrayList<>();
        RedisCommands<String, String> syncCommands = redisConnector.getSyncCommand();
        for (Coordinates zone : zones)
        {
            for(String userId : syncCommands.sinter("latitude:" + zone.latitude + ":users", "longitude:" + zone.longitude + ":users")){
                User user = new User();
                user.setLatitude(Float.parseFloat(syncCommands.get("user:" + userId + ":latitude")));
                user.setLongitude(Float.parseFloat(syncCommands.get("user:" + userId + ":longitude")));
                user.setId(userId);
                users.add(user);
            }
        }
        return users;
    }

    public void putUser(String id, float latitude, float longitude)
    {
        RedisCommands<String, String> syncCommands = redisConnector.getSyncCommand();
        String oldLatitudeStr = syncCommands.get("user:" + id + ":latitude");
        String oldLongitudeStr = syncCommands.get("user:" + id + ":longitude");

        float oldLatitude;
        float oldLongitude;

        if (oldLatitudeStr != null && oldLongitudeStr != null)
        {
            oldLatitude = Float.parseFloat(oldLatitudeStr);
            oldLongitude = Float.parseFloat(oldLongitudeStr);

            Coordinates oldZone = getZone(oldLatitude, oldLongitude);

            syncCommands.srem("latitude:" + oldZone.latitude, id);
            syncCommands.srem("longitude:" + oldZone.longitude, id);
        }


        Coordinates newZone = getZone(latitude, longitude);
        syncCommands.sadd("latitude:" + newZone.latitude + ":users", id);
        syncCommands.sadd("longitude:" + newZone.longitude + ":users", id);

        syncCommands.set("user:"+ id + ":latitude", Float.toString(latitude));
        syncCommands.set("user:"+ id + ":longitude", Float.toString(longitude));
    }

    public User getUser(String id)
    {
        RedisCommands<String, String> syncCommands = redisConnector.getSyncCommand();
        float latitude = Float.parseFloat(syncCommands.get("user:"+ id + ":latitude"));
        float longitude = Float.parseFloat(syncCommands.get("user:"+ id + ":longitude"));
        syncCommands.get("user:"+ id + ":sqlid");
        User user = new User();
        user.setLatitude(latitude);
        user.setLongitude(longitude);
        user.setId(id);
        return user;
    }

    private Coordinates getZone(float latitude, float longitude)
    {
        DecimalFormat df = new DecimalFormat("##.##");
        df.setRoundingMode(RoundingMode.DOWN);
        Coordinates coordinates = new Coordinates(latitude,longitude);
        coordinates.latitude = (coordinates.latitude / 100000) * 100000;
        coordinates.longitude = (coordinates.longitude / 100000) * 100000;
        return coordinates;
    }

    private List<Coordinates> getAroundZone(Coordinates coordinates)
    {
        List<Coordinates> zones = new ArrayList<>();
        zones.add(coordinates);
        zones.add( new Coordinates(coordinates.latitude - 100000, coordinates.longitude - 100000));
        zones.add( new Coordinates(coordinates.latitude - 100000, coordinates.longitude + 0));
        zones.add( new Coordinates(coordinates.latitude - 100000, coordinates.longitude + 100000));

        zones.add( new Coordinates(coordinates.latitude + 0, coordinates.longitude - 100000));
        zones.add( new Coordinates(coordinates.latitude + 0, coordinates.longitude + 100000));

        zones.add( new Coordinates(coordinates.latitude + 100000, coordinates.longitude - 100000));
        zones.add( new Coordinates(coordinates.latitude + 100000, coordinates.longitude + 0));
        zones.add( new Coordinates(coordinates.latitude + 100000, coordinates.longitude + 100000));
        return zones;
    }


    private static class Coordinates{
        public int latitude;
        public int longitude;

        public Coordinates(float latitude, float longitude) {
            this.latitude = (int)(latitude * 10000000);
            this.longitude = (int)(longitude * 10000000);
        }

        public Coordinates(int latitude, int longitude)
        {
            this.latitude = latitude;
            this.longitude = longitude;
        }
        @Override
        public String toString() {
            return "zone:" + latitude + longitude;
        }
    }
}
