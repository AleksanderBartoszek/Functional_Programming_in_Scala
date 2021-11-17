object Main {
    def main(args: Array[String]): Unit = {
        val p = new Point
        p.setColor(56, 0, 120)
        println(p.getColor())

        val pc = new Point with Color
        pc.setColor(56, 0, 120)
        pc.increaseRedBy(20)
        pc.decreaseBlueBy(10)
        println(pc.getColor())
    }
}

trait Color{
    def setColor(r: Float, g: Float, b:Float): Unit
    def getColor(): (Float, Float, Float)

    def changeColor(index: Int, change: Float): Unit = {
        val rgb = getColor()
        index match{
            case 1 => setColor(rgb._1 + change, rgb._2, rgb._3)
            case 2 => setColor(rgb._1, rgb._2 + change, rgb._3)
            case 3 => setColor(rgb._1, rgb._2, rgb._3 + change)
        }
    }

    def increaseRedBy(redPercentage: Float) = changeColor(1, redPercentage)
    def decreaseRedBy(redPercentage: Float) = changeColor(1, -redPercentage)
    def increaseGreenBy(greenPercentage: Float) = changeColor(2, greenPercentage)
    def decreaseGreenBy(greenPercentage: Float) = changeColor(2, -greenPercentage)
    def increaseBlueBy(bluePercentage: Float) = changeColor(3, bluePercentage)
    def decreaseBlueBy(bluePercentage: Float) = changeColor(3, -bluePercentage)
}

class Point{
    private var rgb = (0f, 0f, 0f)

    def setColor(r: Float, g: Float, b:Float) = rgb = (r,g,b)
    def getColor(): (Float, Float, Float) = return (rgb._1, rgb._2, rgb._3)
}
