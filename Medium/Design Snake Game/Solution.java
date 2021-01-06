import java.util.LinkedList;
import java.util.Queue;

class SnakeGame {

	int width, height;
	int[][] food;
	int foodIter = 0;
	int[] nextFood;
	Queue<Tuple> snake;
	Tuple currentHead;

	public SnakeGame(int width, int height, int[][] food) {
		this.width = width;
		this.height = height;
		this.food = food;
		this.snake = new LinkedList();
		this.nextFood = food.length > 0 ? food[0] : new int[] { -1, -1 };
		currentHead = new Tuple(0, 0);
	}

	public int move(String direction) {
		Tuple toIncrement = null;

		if (direction.equals("U"))
			toIncrement = new Tuple(-1, 0);
		if (direction.equals("D"))
			toIncrement = new Tuple(1, 0);
		if (direction.equals("L"))
			toIncrement = new Tuple(0, -1);
		if (direction.equals("R"))
			toIncrement = new Tuple(0, 1);

		int newX = currentHead.x + toIncrement.x;
		int newY = currentHead.y + toIncrement.y;

		if (newX < 0 || newX >= height)
			return -1;
		if (newY < 0 || newY >= width) {
			return -1;
		}

		if (snake.contains(new Tuple(newX, newY))) {
			return -1;
		}

		currentHead = new Tuple(newX, newY);
		if (newX == nextFood[0] && newY == nextFood[1]) {
			if (foodIter != food.length - 1)
				nextFood = food[++foodIter];
			else
				nextFood = new int[] { -1, -1 };
			snake.add(currentHead);
		} else if (snake.size() > 0) {
			snake.poll();
			snake.add(currentHead);
		}

		return snake.size();
	}

}

class Tuple {
	public int x;
	public int y;

	public Tuple(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object other) {
		return x == ((Tuple) other).x && y == ((Tuple) other).y;
	}
}