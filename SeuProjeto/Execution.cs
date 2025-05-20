using System;
class Program {
static void Main() {
int a = int.Parse(Console.ReadLine());
int b = int.Parse(Console.ReadLine());
int sum = a + b;
int diff = a - b;
int prod = a * b;
int quotient = a / b;
if (sum > 10) {
    Console.WriteLine(sum);
    if (diff < 5) {
        int temp = (prod + 2) * diff;
        Console.WriteLine(temp);
    } else {
        temp = (prod / diff) - 3;
        Console.WriteLine(temp);
    }
} else {
    if (quotient == 2) {
        int counter = 5;
        while (counter >= 1) {
            Console.WriteLine(counter);
            counter = counter - 1;
        }
    } else {
        if (a != b) {
            int mod = (a * 2) - (b / 2);
            Console.WriteLine(mod);
        } else {
            Console.WriteLine(0);
        }
    }
}
int result = (sum + diff) * (prod - quotient);
if (result <= 100) {
    Console.WriteLine(result);
} else {
    Console.WriteLine(999);
}
int x = 1;
while (x < 5) {
    int square = x * x;
    Console.WriteLine(square);
    x = x + 1;
}
}}
