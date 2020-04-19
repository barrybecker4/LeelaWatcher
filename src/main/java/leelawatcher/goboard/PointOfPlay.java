/*
    Copyright 2017 Patrick G. Heck

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
 */
package leelawatcher.goboard;

import leelawatcher.goboard.move.Move;

/**
 * The location of a point on a go board.
 * <p>
 * <code>x</code> represents horizontal distance along the edge of the board and <code>y</code> represents vertical
 * distance along the edge of the board. Both of these describe points as if on a cartesian plane with the
 * lower left corner of the board being 0,0. This representation is used for internal referencing of locations.
 * No attempt is made to model the common convention in publications on Go of assigning a letter to the
 * horizontal coordinate and a number to the vertical coordinate. That functionality is to be
 * found in the {@link Move} class. This class is an immutable abstract data class.
 *
 * @author Patrick G. Heck
 */
public class PointOfPlay implements Cloneable {

  private final int x;
  private final int y;

  /**
   * Creates a point at the given (cartesian) coordinates.
   * Only positive coordinates make sense on a go board, so an Illegal
   * argument exception will be thrown if negatives are passed to this
   * constructor.
   *
   * @param xcoor horizontal displacement from the lower left corner of the board.
   * @param ycoor vertical displacement from the lower left corner of the board.
   * @throws IllegalArgumentException if either coordinate is negative
   */
  public PointOfPlay(int xcoor, int ycoor) {

    if (xcoor < -1 || ycoor < -1) {
      String msg = "Can't create negative Point of Play!";
      throw new IllegalArgumentException(msg);
    }
    x = xcoor;
    y = ycoor;
  }

  /**
   * Provides a logical test for equality between PointOfPlay objects.
   * <p>
   * PointOfPlay objects are considered equal if the <code>_x</code> and
   * <code>_y</code> members are equal.
   *
   * @param aPoint A PointOfPlay object to be compared to this instance.
   * @return <code>true</code> if <code>this</code> and
   * <code>aPoint</code> are both equal
   */
  public boolean equals(Object aPoint) {
    PointOfPlay tmp;
    if (aPoint instanceof PointOfPlay)
      tmp = (PointOfPlay) aPoint;
    else
      return false;

    return (tmp.x == this.x && tmp.y == this.y);
  }

  /**
   * Provides a hash code based on the data elements of
   * <code>PointOfPlay</code>.
   * <p>
   * <code>_x</code> and <code>_y</code> contribute to the hash value
   * produced by this method. The algorithm is suggested in Effective Java
   * by Joshua Bloch (2001).
   *
   * @return An integer that is constant for all
   * <code>PointOfPlay</code> objects that are equal
   * according to <code>PointOfPlay.equals</code>.
   */
  public int hashCode() {
    int result = 17;
    result = 37 * result + x;
    result = 37 * result + y;
    return result;
  }

  /**
   * Returns the string representation of a PointOfPlay.
   * <p>
   * The string representation consists of two integers separated by
   * a comma and surrounded by parenthesis, for example "(8,13)" would
   * be returned (without quotation marks) when <code>_x</code> is 8 and
   * <code>_y</code> is 13. The exact lenght of the return value is
   * variable, but in all reasonable board sizes it should be between five
   * and seven characters. There will never be internal, leading or trailing
   * whitespace in the return value.
   *
   * @return A string 5-23 characters in length with no whitespace.
   */
  public String toString() {
    return "(" + x + "," + y + ")";
  }

  /**
   * Returns the contents of <code>_x</code>.
   *
   * @return The horizontal displacement from the lower left corner
   */
  public int getX() {
    return x;
  }

  /**
   * Returns the contents of <code>_y</code>.
   *
   * @return The vertical displacement from the lower left corner
   */
  public int getY() {
    return y;
  }
}
