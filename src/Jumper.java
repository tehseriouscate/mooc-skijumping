import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Jumper implements Comparable<Jumper> {

    private List<Integer> distances;
    private int points;
    private String name;
    private List<Integer> judgesPoints;


    public Jumper(String name)  {
        this.name=name;
        points=0;
        distances=new ArrayList<Integer>();
    }

    public List<Integer> getDistances() {
        return distances;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getJudgesPoints() {
        return judgesPoints;
    }

    public void jump()  {
        int length =(int) (Math.random() * ((120 - 60 + 1))) + 60;
        judgesPoints = new ArrayList<Integer>();

        for (int i=0; i<5; i++) {

            judgesPoints.add((int) (Math.random() * ((20 - 10 + 1))) + 10);
        }
        Collections.sort(judgesPoints);
        distances.add(length);
        this.points+=length+judgesPoints.get(1)+judgesPoints.get(2)+judgesPoints.get(3);


    }

    @Override
    public int compareTo(Jumper jumper) {
//        if (this.getPoints() == jumper.getPoints()) {
//            return 0;
//        }
//        else if (this.getPoints()>jumper.getPoints())   {
//            return 1;
//        }
//        else return -1;
        // the compareTo method returns 0 when comapred objects int values are the SAME.
        // returns positive number (1,2,4, 666, 927452) when this object int value is GREATER than objects value provided in parameter
        // return negative number (-1, -4, -345, -34543457) when this object int value is LESS than objects value provided in parameter
        // So..... Above code can be shrotened to:
        return this.getPoints() - jumper.getPoints();
    }
}
