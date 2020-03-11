package meyti.dogcheck.Model.RequestBody.HeightPoint.User;

import meyti.dogcheck.Model.Entity.HeightPoint;

import java.time.LocalDate;

public class PostHeightPoint {
    private float withers;

    public HeightPoint getHeightPoint()
    {
        HeightPoint heightPoint = new HeightPoint();
        heightPoint.setWithers(withers);
        heightPoint.setDate(LocalDate.now());
        return heightPoint;
    }

    public float getWithers() {
        return withers;
    }

    public PostHeightPoint setWithers(float withers) {
        this.withers = withers;
        return this;
    }
}
