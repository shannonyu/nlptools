package edu.knowitall
package tool
package parse
package graph

import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner

import edu.knowitall.tool.segment.Segment
import tool.sentence.BreezeSentencer

@RunWith(classOf[JUnitRunner])
object BreezeSentencerSpecTest extends Specification {
  val sentencer = new BreezeSentencer
  val document = "He went to work.  He bought a suit.  He ate a melon."
  "breeze sentencer" should {
    "properly sentence" in {
      val segments = sentencer.segment(document).toIndexedSeq
      segments(0) must_== Segment("He went to work.  ", 0)
      segments(1) must_== Segment("He bought a suit.  ", 18)
      segments(2) must_== Segment("He ate a melon.", 37)
    }
  }
}
