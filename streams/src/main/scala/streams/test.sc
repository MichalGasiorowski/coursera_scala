package streams


object test {
  trait SolutionChecker extends GameDef with Solver with StringParserTerrain {
    /**
     * This method applies a list of moves `ls` to the block at position
     * `startPos`. This can be used to verify if a certain list of moves
     * is a valid solution, i.e. leads to the goal.
     */
    def solve(ls: List[Move]): Block =
      ls.foldLeft(startBlock) {
        case (block, move) => move match {
          case Left => block.left
          case Right => block.right
          case Up => block.up
          case Down => block.down
        }
      }
  }

  val Level3 = new SolutionChecker {
    /* terrain for level 3*/

    val level =
      """---------------
      |------ooooooo--
      |oooo--ooo--oo--
      |ooooooooo--oooo
      |oSoo-------ooTo
      |oooo-------oooo
      |------------ooo""".stripMargin
  }                                               //> Level3  : streams.test.SolutionChecker = streams.test$$anonfun$main$1$$anon$
                                                  //| 1@67b64c45

  val Level4 = new SolutionChecker {
    val level =
      """---------------
      |---ooooooo----
      |---ooooooo----
      |oooo-----ooo--
      |ooo-------oo--
      |ooo-------oo--
      |oSo--ooooooooo
      |ooo--ooooooooo
      |-----oTo--oooo
      |-----ooo--oooo""".stripMargin
  }                                               //> Level4  : streams.test.SolutionChecker = streams.test$$anonfun$main$1$$anon
                                                  //| $2@6bf256fa

  val Level6 = new SolutionChecker {
    val level =
      """---------------
    |-----oooooo----
    |-----o--ooo----
    |-----o--ooooo--
    |Sooooo-----oooo
    |----ooo----ooTo
    |----ooo-----ooo
    |------o--oo----
    |------ooooo----
    |------ooooo----
    |-------ooo-----""".stripMargin
  }                                               //> Level6  : streams.test.SolutionChecker = streams.test$$anonfun$main$1$$anon
                                                  //| $3@6cd8737
	val sol = Level6.solution                 //> sol  : List[streams.test.Level6.Move] = List(Right, Down, Down, Right, Down
                                                  //| , Right, Right, Up, Left, Down, Down, Right, Right, Right, Up, Up, Up, Left
                                                  //| , Up, Up, Left, Left, Left, Up, Right, Down, Down, Right, Down, Down, Right
                                                  //| , Down, Right, Right, Right)
  Level6.done(Level6.solve(sol))                  //> res0: Boolean = true

}