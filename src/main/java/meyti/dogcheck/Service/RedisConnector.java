package meyti.dogcheck.Service;


import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import org.springframework.stereotype.Service;

@Service
public class RedisConnector {
    private RedisClient redisClient;

    private StatefulRedisConnection<String, String> connection;
    public RedisConnector() {
        redisClient = RedisClient
                .create("redis://@localhost:6379/");
        connection = redisClient.connect();

        RedisCommands<String, String> syncCommands = connection.sync();
        syncCommands.set("key", "Hello, Redis!");
        syncCommands.lpush("key2", "test");
        syncCommands.lpush("key2", "test");

//        String value = syncCommands.hgetall("key2");
    }

    public RedisClient getRedisClient() {
        return redisClient;
    }

    public RedisCommands<String, String> getSyncCommand()
    {
        return connection.sync();
    }
}
