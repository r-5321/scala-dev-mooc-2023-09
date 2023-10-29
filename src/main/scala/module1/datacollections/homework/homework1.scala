package module1.datacollections.homework

import scala.util.Random

class BallsExperiment {

  def shaker(list: List[Int]): List[Int] = Random.shuffle(list)


  val UrnList: List[Int] = shaker(List.fill(3)(1) ++ List.fill(3)(0))


  def isFirstBlackSecondWhite(): Boolean = {
    val firstBall = UrnList.head
    val secondBall = shaker(UrnList.tail)
    if (firstBall == 1 || secondBall == 1) true else false
  }
}

object BallsTest {
  def main(args: Array[String]): Unit = {
    val count = 10000
    val listOfExperiments: List[BallsExperiment] = List.fill(count)(new BallsExperiment)
    val countOfExperiments = listOfExperiments.map(e => e.isFirstBlackSecondWhite())
    val countOfPositiveExperiments: Float = countOfExperiments.count(_ == true)
    println(countOfPositiveExperiments / count)
  }
}