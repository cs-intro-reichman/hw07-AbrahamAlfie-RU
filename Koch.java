/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		// curve(Integer.parseInt(args[0]),
			//   Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		    //   Double.parseDouble(args[3]), Double.parseDouble(args[4]));

		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
public static void curve(int n, double x1, double y1, double x2, double y2) {
    if (n == 0) {
        StdDraw.line(x1, y1, x2, y2);
        return;
    }

    double dx = x2 - x1;
    double dy = y2 - y1;

    double xA = x1 + dx / 3.0;
    double yA = y1 + dy / 3.0;

    double xB = x1 + 2.0 * dx / 3.0;
    double yB = y1 + 2.0 * dy / 3.0;

    double xC = 0.5 * (xA + xB) - (Math.sqrt(3) / 6.0) * dy;
    double yC = 0.5 * (yA + yB) + (Math.sqrt(3) / 6.0) * dx;

    curve(n - 1, x1, y1, xA, yA);
    curve(n - 1, xA, yA, xC, yC);
    curve(n - 1, xC, yC, xB, yB);
    curve(n - 1, xB, yB, x2, y2);
}

public static void snowFlake(int n) {
    StdDraw.setXscale(-0.2, 1.3);
    StdDraw.setYscale(-0.2, 1.3);

    double x1 = 0.1, y1 = 0.1;
    double x2 = 1.0, y2 = 0.1;
    double x3 = 0.55, y3 = 0.1 + 0.9 * Math.sqrt(3) / 2.0;

    curve(n, x1, y1, x3, y3);
    curve(n, x3, y3, x2, y2);
    curve(n, x2, y2, x1, y1);
	}
}
