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

package leelawatcher;

/**
 * A central location for application wide constants. Any immutable value
 * needed by multiple classes, or relating to the application as a whole
 * should be defined here.
 *
 * @author Patrick G. Heck
 */

public interface TsbConstants {
  /**
   * The current version of the program. String is used since the value
   * of the version is never used in computation.
   */
  String VERSION_STR = "1.0";

  /**
   * The name of the program.
   */
  String PROG_NAME = "LeelaWatcher";

  /**
   * The location of the woodgrain image file used as a background for the
   * playing board.
   */
  String BRD_BACKGRD = "images/wd-back.gif";
}
