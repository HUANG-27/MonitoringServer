package com.project.server.entity;

public class Orientation{

    private double heading;     //偏航角，从正北方向开始顺时针旋转，到手机后置相机方向（从手机底部指向顶部）的夹角
    private double roll;    //滚转角，手机左侧抬高为负，右侧抬高为正；
    private double pitch;   //俯仰角，手机顶部抬高为负，底部抬高为正；

    public double getHeading() {
        return heading;
    }

    public void setHeading(double heading) {
        this.heading = heading;
    }

    public double getRoll() {
        return roll;
    }

    public void setRoll(double roll) {
        this.roll = roll;
    }

    public double getPitch() {
        return pitch;
    }

    public void setPitch(double pitch) {
        this.pitch = pitch;
    }

    public Orientation() {
        setHeading(0d);
        setRoll(0d);
        setPitch(0d);
    }

    public Orientation(double heading, double roll, double pitch) {
        setHeading(heading);
        setRoll(roll);
        setPitch(pitch);
    }
}
