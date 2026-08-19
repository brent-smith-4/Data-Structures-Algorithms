All programs should be compiled already.
Program runs with this command, assuming you are in the 04-sorting-algorithms folder:

Experiment 1:
$ java SortDriver.java <input file name>

Experiment 2:
$ java ExpDriver.java
    *Will first ask for size of input, enter integer (ex: 10000)
    *Will then ask for sorting method to use, enter same commands as used in Experiment 1

# Sorting Algorithms

Implementations and empirical performance analysis of six classic sorting algorithms: Selection Sort, Merge Sort, Heap Sort, Quick Sort (first-element pivot), Quick Sort (random pivot), and their driver/test harness.

## Experiment 1: Comparison Counts by Input Ordering

Ran each algorithm on ordered, random, and reverse-sorted input, counting comparisons:

- **Selection Sort** stayed at ~50M comparisons regardless of input ordering, consistent with its O(n²) worst/average/best case being identical.
- **Merge Sort** stayed in the 60K–180K range across all orderings, O(n log n) as expected.
- **Heap Sort** consistently required more comparisons than Merge Sort despite sharing O(n log n) complexity. Converges toward selection sort behavior on larger inputs.
- **Quick Sort (first-element pivot)** hit O(n²) worst case (~50M comparisons) on already-sorted and reverse-sorted input, since a fixed first element pivot is a known worst case.
- **Quick Sort (random pivot)** stayed in the O(n log n) range (~150K comparisons) across all three orderings. Shows why randomized pivot is the safest choice.

**Conclusion:** Merge Sort had the lowest overall comparison counts. Randomized-pivot Quick Sort is strictly safer than first-element-pivot Quick Sort, since it isn't vulnerable to adversarial or already-ordered input triggering worst-case behavior.

## Experiment 2: Scaling Behavior (Averaged Over Multiple Samples)

Measured average comparison counts across input sizes from 100 to 30,000 elements:

| Input Size (n) | Selection Sort | Merge Sort | Heap Sort | Quick Sort (fp) | Quick Sort (rp) |
|---|---|---|---|---|---|
| 100 | 4,950 | 820 | 1,256 | 740 | 608 |
| 1,000 | 499,500 | 13,075 | 19,158 | 11,864 | 11,322 |
| 10,000 | 49,995,000 | 181,520 | 258,277 | 165,890 | 153,836 |
| 30,000 | 449,985,000 | 615,323 | 869,690 | 556,169 | 521,774 |

Results closely followed theoretical time complexity: Selection Sort's comparisons scaled quadratically while Merge Sort, Heap Sort, and both Quick Sort variants scaled log-linearly. Heap Sort consistently trailed Merge Sort and Quick Sort at scale despite sharing the same complexity.

Full write-up with methodology and analysis: [`Sorting_Algorithm_Experiment.pdf`](./Sorting_Algorithm_Experiment.pdf)
