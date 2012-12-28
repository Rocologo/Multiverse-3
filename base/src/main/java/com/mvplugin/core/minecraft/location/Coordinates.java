package com.mvplugin.core.minecraft.location;

/**
 * Represents a point in 3-dimensional space.
 */
public interface Coordinates extends Cloneable {

    /**
     * Gets the x coordinate of this point.
     *
     * @return The x coordinate of this point.
     */
    double getX();

    /**
     * Gets the y coordinate of this point.
     *
     * @return The y coordinate of this point.
     */
    double getY();

    /**
     * Gets the z coordinate of this point.
     *
     * @return The z coordinate of this point.
     */
    double getZ();

    void add(final double x, final double y, final double z);

    @Override
    Coordinates clone();
}