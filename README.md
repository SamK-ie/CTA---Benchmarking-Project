# CTA - Benchmarking Project

---

## Overview
This project contains a core Java benchmarking application developed to analyse the empirical performance ($A\ Posteriori$) against the theoretical complexity ($A\ Priori$) of comparison and non-comparison sorting algorithms. Built as a core project for the Computational Thinking and Algorithms module of the Higher Diploma in Software Development curriculum, the application generates randomised datasets across varying input sizes ($n$) to output a clean performance matrix. The codebase demonstrates proficiency in algorithmic design, deep array isolation, and high-precision execution tracking, structured cleanly to showcase technical maintainability to technical recruiters.

---

## Features
- Benchmark five distinct sorting techniques: Bubble Sort, Selection Sort, Insertion Sort, Merge Sort, and Counting Sort.
- Generate randomised integer datasets across a wide spectrum of input bounds up to 10,000 elements.
- Execute a high-precision, nested iteration benchmarking loop running 10 repetitions per input size to calculate true runtime averages.
- Zero external package dependencies, leveraging native Java utilities for instant portability across any platform-independent CLI.

---

## Installation

1. Clone the repository:
```bash
git clone https://github.com/SamK-ie/Java-Sorting-Benchmarker-Project.git
```
2. Navigate to the source root directory:
```bash
cd Java-Sorting-Benchmarker-Project/src
```
3. Compile the source code via the CLI:
```bash
javac -d . Sorting.java
```

---

## Execution and Usage

### Algorithmic Performance Benchmarker

1. Run the compiled bytecode application engine to execute the performance tests:
```bash
 java BenchmarkingProject.src.Sorting
```
2. The application will automatically process the datasets and output the metric matrix.

### Expected Interface Output Example
```plaintext
Array Size | Bubble Sort | Selection Sort | Insertion Sort | Merge Sort | Counting Sort
       100 |       0.152 |          0.083 |          0.048 |      0.047 |        0.010
       500 |       0.244 |          0.173 |          0.141 |      0.064 |        0.035
      1000 |       0.752 |          0.710 |          0.102 |      0.169 |        0.019
      5000 |      12.253 |          4.842 |          1.686 |      0.558 |        0.018
     10000 |      77.520 |         19.173 |          6.704 |      1.049 |        0.036
```

### Supported Algorithms & Complexity Reference

| Algorithm | Type | Time Complexity (Best) | Time Complexity (Average/Worst) | Space Complexity |
| :--- | :--- | :--- | :--- | :--- |
| **Bubble Sort** | In-place / Stable Comparison | $O(n)$ | $O(n^2)$ | $O(1)$ |
| **Selection Sort** | In-place / Unstable Comparison | $O(n)$ | $O(n^2)$ | $O(1)$ |
| **Insertion Sort** | In-place / Stable Comparison | $O(n)$ | $O(n^2)$ | $O(1)$ |
| **Merge Sort** | Divide & Conquer / Stable | $O(n \log n)$ | $O(n \log n)$ | $O(n)$ |
| **Counting Sort** | Non-Comparison / Stable Integer | $O(n + k)$ | $O(n + k)$ | $O(n + k)$ |

---

## Production Hardening Roadmap
To demonstrate how this localised benchmarker scales toward enterprise-ready software pipelines, the following architectural milestones are planned:

- **Decoupled Data Payloads:** Shifting from random dataset generation to explicit storage platforms that process raw API payloads or external JSON configurations dynamically throughout the day.
- **Visual Analytics Layer:** Integrating an umbrella reporting framework or frontend components to plot the execution tables into real-time linearithmic and quadratic performance curves.
- **Dynamic Range Optimisation:** Enhancing Counting Sort memory management to gracefully intercept constraints where the value range ($k$) heavily exceeds volume ($n$), preventing performance degradation.

---

## License
This project is open-source software distributed under the terms of the MIT License.

---

## Contributing
Contributions are welcome!
If you have suggestions for structural improvements, data parsing additions, or extra automation features, please fork the repository and submit a pull request.

---

## Authors
Samantha Kenny [@SamK-ie](https://github.com/SamK-ie)
