class TaxiCabNumbers {
    public int findTaxiCabNumber(final int number, final int possibleWays) {
        int num = number;
        int ways = possibleWays;
        int n = 600;

        // initialize priority queue
        MinPQ<CubeSum> pq = new MinPQ<CubeSum>();
        for (int i = 0; i <= n; i++) {
            pq.insert(new CubeSum(i, i));
        }
        int previous = -1;
        int numCounter = 0;
        int waysCounter = 1;
        // find smallest sum, print it out, and update

        while (!pq.isEmpty()) {
            CubeSum s = pq.delMin();
            //System.out.println("This is while: ");
            if (previous == s.sum) {
                waysCounter++;
            } else {
                waysCounter = 0;
            }

            if (waysCounter == ways - 1) {
                numCounter++;
                if (numCounter == num) {
                    return s.sum;
                }
            }
            previous = s.sum;
            //StdOut.println(s);
            if (s.j < n) {
                pq.insert(new CubeSum(s.i, s.j + 1));
            }
        }
        return -1;
    }
}