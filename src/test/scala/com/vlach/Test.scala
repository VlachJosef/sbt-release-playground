package com.vlach

import org.scalatest.{Matchers, FlatSpec}

class TestSuite extends FlatSpec with Matchers {
  "Test" should "test this test" in {
    "test".toUpperCase should be("TEST")
  }
}
