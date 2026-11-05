import java.util.*;


class Min_Area_of_Rectangle {

    public long minArea(String path, int fr, int fc) {

        int n = getMinDimension(path, fr, 'D', 'U');
        if (n == -1) return -1;

        int m = getMinDimension(path, fc, 'R', 'L');
        if (m == -1) return -1;

        return 1L * n * m;  
    }

    private int getMinDimension(String path, int target, char incChar, char decChar) {

        int low = target + 1;
        int high = path.length() + target + 2;

        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int limitIdx = mid - 1;

            int curr = 0;

            for (int i = 0; i < path.length(); i++) {
                char ch = path.charAt(i);

                if (ch == incChar) {
                    if (curr < limitIdx) curr++;
                } else if (ch == decChar) {
                    if (curr > 0) curr--;
                }
            }

            if (curr >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (ans == -1) return -1;

        int curr = 0;
        int limitIdx = ans - 1;

        for (int i = 0; i < path.length(); i++) {
            char ch = path.charAt(i);

            if (ch == incChar) {
                if (curr < limitIdx) curr++;
            } else if (ch == decChar) {
                if (curr > 0) curr--;
            }
        }

        return (curr == target) ? ans : -1;
    }
}