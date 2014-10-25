package patmat

import patmat.Huffman._

object testSheet {
  //val chars = List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd')

  val chars = List('h', 'e', 'l', 'l')            //> chars  : List[Char] = List(h, e, l, l)

  val cc = createCodeTree(chars)                  //> cc  : patmat.Huffman.CodeTree = Fork(Leaf(l,2),Fork(Leaf(e,1),Leaf(h,1),List
                                                  //| (e, h),2),List(l, e, h),4)

  decodedSecret                                   //> res0: List[Char] = List(h, u, f, f, m, a, n, e, s, t, c, o, o, l)

  val t1 = Fork(Leaf('a', 2), Leaf('b', 3), List('a', 'b'), 5)
                                                  //> t1  : patmat.Huffman.Fork = Fork(Leaf(a,2),Leaf(b,3),List(a, b),5)
                                                  
  val t2 = Fork(Fork(Leaf('a', 2), Leaf('b', 3), List('a', 'b'), 5), Leaf('d', 4), List('a', 'b', 'd'), 9)
                                                  //> t2  : patmat.Huffman.Fork = Fork(Fork(Leaf(a,2),Leaf(b,3),List(a, b),5),Leaf
                                                  //| (d,4),List(a, b, d),9)
  
                                                  
  val en2 = encode(t2)("abbdda".toList)           //> en2  : List[patmat.Huffman.Bit] = List(0, 0, 0, 1, 0, 1, 1, 1, 0, 0)

	val de2 = decode(t2, en2)                 //> de2  : List[Char] = List(a, b, b, d, d, a)

  List('a', 'b').contains('a')                    //> res1: Boolean = true

  convert(t2)                                     //> res2: patmat.Huffman.CodeTable = List((a,List(0, 0)), (b,List(0, 1)), (d,Lis
                                                  //| t(1)))

  quickEncode(t2)("abbdda".toList)                //> res3: List[patmat.Huffman.Bit] = List(0, 0, 0, 1, 0, 1, 1, 1, 0, 0)


	val ex1=createCodeTree("AAAAAAAABBBCDEFGH".toList)
                                                  //> ex1  : patmat.Huffman.CodeTree = Fork(Leaf(A,8),Fork(Fork(Fork(Leaf(H,1),Lea
                                                  //| f(G,1),List(H, G),2),Fork(Leaf(F,1),Leaf(E,1),List(F, E),2),List(H, G, F, E)
                                                  //| ,4),Fork(Fork(Leaf(D,1),Leaf(C,1),List(D, C),2),Leaf(B,3),List(D, C, B),5),L
                                                  //| ist(H, G, F, E, D, C, B),9),List(A, H, G, F, E, D, C, B),17)
	 val encd=encode(ex1)("D".toList)         //> encd  : List[patmat.Huffman.Bit] = List(1, 1, 0, 0)
 
}