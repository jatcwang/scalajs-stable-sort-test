package com.skedulo.test

import org.scalacheck.Gen
import org.scalatest._
import org.scalatest.prop.{GeneratorDrivenPropertyChecks, PropertyChecks}

class TestClassSpec extends WordSpec with Matchers with PropertyChecks {
  "Sort" should {
    "Be Stable" in {
      case class TestClass(id: String, value: Int) extends Ordered[TestClass] {
        override def compare(that: TestClass): Int = this.value compare that.value

        override def toString: String = s"""TestClass("$id", $value)"""
      }
      def gen_TestClass = for {
        id <- Gen.alphaStr
        value <- Gen.posNum[Int]
      } yield TestClass(id, value)
      forAll(Gen.containerOf[Seq, TestClass](gen_TestClass)) { list =>
        assert(list.sorted.sorted === list.sorted)
      }(PropertyCheckConfiguration(minSuccessful = 10000), implicitly, implicitly)
    }
  }
}
