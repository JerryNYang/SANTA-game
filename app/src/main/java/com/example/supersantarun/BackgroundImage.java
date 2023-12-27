package com.example.supersantarun;

// manage scrolling background image
public class BackgroundImage {

    private int backgroundImageX, backgroundImageY, backgroundImageVelocity;

    public BackgroundImage()
    {
        backgroundImageX = 0;
        backgroundImageY = 0;
        backgroundImageVelocity = 3;
    }

    public int getX()
    {
        return backgroundImageX;
    }

    public int getY()
    {
        return backgroundImageY;
    }
    public void setX(int backgroundImageX)
    {
        this.backgroundImageX = backgroundImageY;
    }

    public int getVelocity()
    {
        return backgroundImageVelocity;
    }
}
