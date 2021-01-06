class Solution {
	public int countArrangement(int n) {
		List<List<Integer>> lista = new ArrayList();
		for (int i = 1; i <= n; ++i) {
			List<Integer> temp = new ArrayList();
			for (int k = 1; k <= n; ++k) {
				if (i % k == 0 || k % i == 0)
					temp.add(k);
			}
			lista.add(temp);
		}
		int[] result = new int[1];
		permutation(lista, new ArrayList<Integer>(), result, 0, -1);
		return result[0];
	}

	public void permutation(List<List<Integer>> lista, List<Integer> numbers, int[] result, int depth,
			Integer newElement) {
		if (numbers.contains(newElement))
			return;
		if (depth == lista.size()) {
			numbers.add(newElement);
            result[0]++;
			numbers.remove(newElement);
		} else {
			if (newElement != -1)
				numbers.add(newElement);
			for (Integer iter : lista.get(depth))
				permutation(lista, numbers, result, depth + 1, iter);
			numbers.remove(newElement);
		}

		return;
	}

}