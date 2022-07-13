#include <iostream>
#include <cassert>
using namespace std;

class Stack
{
public:
    int array[10];
    int next;

    void reset()
    {
        next = 0;
        for (int i = 0; i < 10; ++i) array[i] = 0;
    }

    bool push(int c)
    {
        if (next == 10) return false;
        array[next++] = c;
        return true;
    }

    int pop()
    {
        assert(next > 0 && "Stack empty");
        return array[--next];
        
          
    }

    void print()
    {
        cout << "( ";
        for (int i = 0; i < next; ++i) cout << array[i] << ' ';
        cout << ")\n";
    }
};

int main()
{
    Stack stack;
    stack.reset();

    stack.print();

    stack.push(3);
    stack.push(7);
    stack.push(5);
    stack.print();

    stack.pop();
    stack.print();

    stack.pop();
    stack.pop();

    stack.print();
    
    return 0;
}