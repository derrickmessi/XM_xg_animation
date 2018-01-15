package com.example.administrator.myanimation.view;


/**
 * Created by zz on 2017/10/16.
 */

public class Bolls {
    private float cx;
    private float cy;
    private float radius;
    private int addx;
    private int addy;
    private int addRadius;
    MySurfaceView view;
    private int type;
    private int width;
    private int height;

    // tpye 区分坐标四个象限

    public Bolls(MySurfaceView view, float x, float y, int type, int width, int height) {
        this.view = view;

        this.cx = x;
        this.cy = y;
        this.type = type;
        this.width = width / 2;
        this.height = height / 2;
        radius = (float) (Math.random() * 3 + 10);
        addx = (int) (Math.random() * 10);
        addy = (int) (Math.random() * 10);
        addRadius = (int) (Math.random() * 10);
    }

    public float getCx() {
        return cx;
    }

    public void setCx(float cx) {
        this.cx = cx;
    }

    public float getCy() {
        return cy;
    }

    public void setCy(float cy) {
        this.cy = cy;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public void draw() {
        float rate = Math.abs((height - cy) / (width - cx));
        int s = 1;
        int r = 260;
        switch (type) {
            case 1:
                changePointSize(radius);

                if (cx - width <= r && height - cy <= r) {
                    cx = -1;
                    cy = -1;
                } else if (cx >= 0 && cy >= 0) {
                    if (rate > 3) {
                        cx -= s;
                        cy = r + height;
                    } else if (rate < 3 && rate > 0.5) {
                        cx -= 2 * s;
                        cy += 2 * rate * s;
                    } else if (rate < 0.5) {
                        cx -= 2 * s;
                        cy += s;
                    }
                }
                break;
            case 2:
                changePointSize(radius);
                if (width - cx <= r && height - cy <= r) {
                    cx = -1;
                    cy = -1;
                } else if (cx >= 0 && cy >= 0) {
                    if (rate > 3) {
                        cx += s;
                        cy += 3 * s;
                    } else if (rate < 3 && rate > 0.5) {
                        cx += 2 * s;
                        cy += 2 * rate * s;
                    } else if (rate < 0.5) {
                        cy += s;
                        cx += 2 * s;

                    }
                }
                break;

            case 3:
                changePointSize(radius);

                if (width - cx <= r && cy - height <= r) {
                    cx = -1;
                    cy = -1;
                } else if (cx >= 0 && cy >= 0) {
                    if (rate > 3) {
                        cx += s;
                        cy -= 3 * s;
                    } else if (rate < 3 && rate > 0.5) {
                        cx += 2 * s;
                        cy -= 2 * rate * s;
                    } else if (rate < 0.5) {
                        cx += 2 * s;
                        cy -= s;
                    }
                }
                break;

            case 4:
                changePointSize(radius);
                if (cx - width <= r && cy - height <= r) {
                    cx = -1;
                    cy = -1;
                } else if (cx >= 0 && cy >= 0) {
                    if (rate > 3) {
                        cx -= s;
                        if (cy >= r + height) {
                            cy -= 3 * s;
                        } else {
                            cy = r + height;
                        }
                    } else if (rate < 3 && rate > 0.5) {
                        cx -= 2 * s;
                        cy -= 2 * rate * s;
                    } else if (rate < 0.5) {
                        if (cx >= r + width) {
                            cx -= 2 * s;
                        } else {
                            cx = r + width;
                        }
                        cy -= s;
                    }
                }
                break;
            default:
                cx = -1;
                cy = -1;
                break;
        }
    }

    private void changePointSize(float size) {
        if (size > 5 && size < 13) {
            radius -= 0.1;
        } else if (size < 5) {
            radius = 5;
        }
    }

}
