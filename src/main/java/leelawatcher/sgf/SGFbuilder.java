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

package leelawatcher.sgf;

import leelawatcher.TsbConstants;
import leelawatcher.goboard.Game;
import leelawatcher.goboard.move.Move;

/**
 * This class is meant to simply provide a routine for converting a game object
 * to a string that conforms to SGF FF[4]. game.java extends this class
 */
public class SGFbuilder implements SGFproperties, TsbConstants {

  public SGFbuilder() {
  }

  public String SGFprintMoves(Move aMove) {
    StringBuilder tmp = new StringBuilder("");
    int numChild = aMove.numChildren();

    for (int i = 0; i < numChild; i++) {
      if ((i == 0) && !aMove.isRoot()) {
        tmp.append(";").append(aMove);
      }

      if (numChild > 1)
        tmp.append("(");

      if (aMove.next() != aMove)               // if shouldn't be needed
        tmp.append(SGFprintMoves(aMove.next(i))); // due to for loop, but...

      if (numChild > 1)
        tmp.append(")");
    }

    if (numChild == 0)
      tmp.append(";").append(aMove);

    return tmp.toString();
  }


  public String buildSGF(Game gm) {

    String tmp = "";
    tmp += "(;" + FILEFORMAT + "[" + FORMAT_VERSION + "]" + GAMETYPE + "[1]\n\n";

    tmp += APPLICATION + "[" + PROG_NAME + " " + VERSION_STR + "]\n\n";

    tmp += GAMENAME + "[" + gm.getGameName() + "]\n";
    tmp += EVENT + "[" + gm.getGameEvent() + "]\n";
    tmp += RESULT + "[" + gm.getGameResult() + "]\n";
    tmp += DATE + "[" + gm.getDate() + "] ";
    tmp += PLACE + "[" + gm.getPlace() + "]\n";
    tmp += GAMEINFO + "[" + gm.getGameNotes() + "]\n\n";

    tmp += PLAYERWHITE + "[" + gm.getWName() + "] ";
    tmp += WHITERANK + "[" + gm.getTradWRank() + "]\n";
    tmp += PLAYERBLACK + "[" + gm.getBName() + "] ";
    tmp += BLACKRANK + "[" + gm.getTradBRank() + "]\n\n";
    tmp += HANDICAP + "[" + gm.getHandi() + "] ";
    tmp += KOMI + "[" + gm.getKomi() + "] ";
    tmp += SIZE + "[" + gm.getBoardSize() + "]\n";
    tmp += RULES + "[" + gm.getRuleSet() + "]\n\n";

    tmp += SGFprintMoves(gm.movesRoot());

    tmp += ")\n";
    return tmp;

  }

}









