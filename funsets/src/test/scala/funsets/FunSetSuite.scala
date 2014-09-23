package funsets

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class is a test suite for the methods in object FunSets. To run
 * the test suite, you can either:
 *  - run the "test" command in the SBT console
 *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {


  /**
   * Link to the scaladoc - very clear and detailed tutorial of FunSuite
   *
   * http://doc.scalatest.org/1.9.1/index.html#org.scalatest.FunSuite
   *
   * Operators
   *  - test
   *  - ignore
   *  - pending
   */

  /**
   * Tests are written using the "test" operator and the "assert" method.
   */
  test("string take") {
    val message = "hello, world"
    assert(message.take(5) == "hello")
  }

  /**
   * For ScalaTest tests, there exists a special equality operator "===" that
   * can be used inside "assert". If the assertion fails, the two values will
   * be printed in the error message. Otherwise, when using "==", the test
   * error message will only say "assertion failed", without showing the values.
   *
   * Try it out! Change the values so that the assertion fails, and look at the
   * error message.
   */
  test("adding ints") {
    assert(1 + 2 === 3)
  }

  
  import FunSets._

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }
  
  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   * 
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   * 
   *   val s1 = singletonSet(1)
   * 
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   * 
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   * 
   */

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
    val s4 = singletonSet(4)
    
    val s8 = singletonSet(8)
    
    val s16 = singletonSet(16)
    
    val s_1_2 = union(s1, s2)
    val s_1_2_3 = union(s_1_2, s3)
    
    def filter_even(p: Int): Boolean = p % 2 == 0
    def filter_odd(p: Int): Boolean = p % 2 != 0
    def filter_more_than_10(p: Int): Boolean = p > 10
    
    def times2(x: Int): Int = x * 2
    
  }

  /**
   * This test is currently disabled (by using "ignore") because the method
   * "singletonSet" is not yet implemented and the test would fail.
   * 
   * Once you finish your implementation of "singletonSet", exchange the
   * function "ignore" by "test".
   */
  test("singletonSet(1) contains 1") {
    
    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3". 
     */
    new TestSets {
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton")
    }
  }

  test("union contains all elements") {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }
  
  test("intersect contains no elements") {
    new TestSets {
      val s = intersect(s1, s2)
      assert(!contains(s, 1), "Intersect 1")
      assert(!contains(s, 2), "Intersect 2")
      assert(!contains(s, 3), "Intersect 3")
    }
  }
  
  test("intersect tests no elements") {
    new TestSets {
      val s = intersect(s1, s4)
      assert(!contains(s, 1), "Intersect 1")
      assert(!contains(s, 2), "Intersect 2")
      assert(!contains(s, 3), "Intersect 3")
    }
  }
  
  test("diff tests 1 elements. sets with 1 element") {
    new TestSets {
      val s = diff(s1, s2)
      assert(contains(s, 1), "diff 1")
      assert(!contains(s, 2), "diff 2")
      assert(!contains(s, 3), "diff 3")
    }
  }
  
  test("diff tests 1 elements") {
    new TestSets {
      val s = diff(s_1_2_3, s_1_2)
      assert(!contains(s, 1), "diff 1")
      assert(!contains(s, 2), "diff 2")
      assert(contains(s, 3), "diff 3")
    }
  }
  
  test("filter_odd tests 1 elements") {
    new TestSets {
      val s = filter(filter_odd, s_1_2_3)
      assert(contains(s, 1), "filter 1")
      assert(!contains(s, 2), "filter 2")
      assert(contains(s, 3), "filter 3")
    }
  }
  
  test("filter_even tests 1 elements") {
    new TestSets {
      val s = filter(filter_even, s_1_2_3)
      assert(!contains(s, 1), "filter 1")
      assert(contains(s, 2), "filter 2")
      assert(!contains(s, 3), "filter 3")
    }
  }
  
  test("filter_more_than_10 tests 1 elements") {
    new TestSets {
      val s = filter(filter_more_than_10, s16)
      assert(!contains(s, 1), "filter 1")
      assert(!contains(s, 2), "filter 2")
      assert(!contains(s, 3), "filter 3")
      assert(contains(s, 16), "filter 16")
    }
  }
  
  test("forall filter_even tests s_1_2_3") {
    new TestSets {
      val b = forall(s_1_2_3, filter_even)
      assert(!b, "forall not all even 1")
    }
  }
  
  test("forall filter_even tests s2") {
    new TestSets {
      val b = forall(s2, filter_even)
      assert(b, "forall not all even 2")
    }
  }
  
  test("forall filter_even tests s_2_4_8") {
    new TestSets {
      val s = union(union(s2, s4), s8)
      val b = forall(s, filter_even)
      assert(b, "forall all even 3")
    }
  }
  
  test("exists filter_even tests s1") {
    new TestSets {
      val s = s1
      val b = exists(s, filter_even)
      assert(!b, "not exists even in s1")
    }
  }
  
  test("exists filter_even tests s2") {
    new TestSets {
      val s = s2
      val b = exists(s, filter_even)
      assert(b, "exists even in s1")
    }
  }
  
  test("exists filter_odd tests s1_2_4_8") {
    new TestSets {
      val s = union(union(union(s1, s2), s4), s8)
      val b = exists(s, filter_odd)
      assert(b, "exists odd in s1_2_4_8")
    }
  }
  
  test("exists filter_more_than_10 tests s1_2_4_8_16") {
    new TestSets {
      val s = union(union(union(union(s1, s2), s4), s8), s16)
      val b = exists(s, filter_more_than_10)
      assert(b, "exists even in s1_2_4_8_16")
    }
  }
  
  test("map times_1 test") {
    new TestSets {
      val s = map(s1, x => x)
      assert(contains(s, 1), "map 1")
      assert(!contains(s, 2), "map 2")
    }
  }
  
  test("map times_2 test") {
    new TestSets {
      val s = map(s1, x => 2 * x)
      assert(!contains(s, 1), "map 1")
      assert(contains(s, 2), "map 2")
    }
  }
  
  test("map times_2 more complicated test") {
    new TestSets {
      val s = map(s_1_2_3, x => 2 * x)
      assert(!contains(s, 1), "map 1")
      assert(contains(s, 2), "map 2")
      assert(!contains(s, 3), "map 3")
      assert(contains(s, 4), "map 4")
      assert(!contains(s, 5), "map 5")
      assert(contains(s, 6), "map 6")
    }
  }
  
  
  
  
  
  
  
}
