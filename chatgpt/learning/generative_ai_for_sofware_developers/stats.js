
function calculateMean(numbers) {
    const sum = numbers.reduce((acc, num) => acc + num, 0);
    return sum / numbers.length;
}


function calculateMedian(numbers) {
    const sorted = [...numbers].sort((a, b) => a - b);
    const mid = Math.floor(sorted.length / 2);

    if (sorted.length % 2 === 0) {
        return (sorted[mid - 1] + sorted[mid]) / 2;
    } else {
        return sorted[mid];
    }
}


function calculateMode(numbers) {
    const frequency = {};
    let maxFreq = 0;
    let modes = [];

    numbers.forEach(num => {
        frequency[num] = (frequency[num] || 0) + 1;
        if (frequency[num] > maxFreq) {
            maxFreq = frequency[num];
        }
    });

    for (const num in frequency) {
        if (frequency[num] === maxFreq) {
            modes.push(Number(num));
        }
    }

    return modes;
}


function calculateVariance(numbers) {
    const mean = calculateMean(numbers);
    const squaredDifferences = numbers.map(num => Math.pow(num - mean, 2));
    return calculateMean(squaredDifferences);
}


function calculateStandardDeviation(numbers) {
    const variance = calculateVariance(numbers);
    return Math.sqrt(variance);
}


const numbers = [1, 2, 2, 3, 4, 5, 5, 5, 6];

console.log("Mean:", calculateMean(numbers)); // Output: Mean
console.log("Median:", calculateMedian(numbers)); // Output: Median
console.log("Mode:", calculateMode(numbers)); // Output: Mode
console.log("Variance:", calculateVariance(numbers)); // Output: Variance
console.log("Standard Deviation:", calculateStandardDeviation(numbers)); // Output: Standard Deviation


function descriptiveStatistics(numbers) {
    return {
        mean: calculateMean(numbers),
        median: calculateMedian(numbers),
        mode: calculateMode(numbers),
        variance: calculateVariance(numbers),
        standardDeviation: calculateStandardDeviation(numbers)
    };
}


const stats = descriptiveStatistics(numbers);

console.log("Descriptive Statistics:", stats);

