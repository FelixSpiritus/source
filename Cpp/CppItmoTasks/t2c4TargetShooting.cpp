#include <iostream>
#include<cmath>
using std::endl;
using std::cout;
using std::cin;
using std::string;

struct Coord
{
    int x;
    int y;
};

struct Target
{
    Coord CenterTarget;
    int r10;
    int r5;
    int r1;
};

string ShooterLevel(int i) {
    if (i <= 5)
        return "SNIPER";
    else if (i > 5 && i <= 10)
        return "SHOOTER";
    else
        return "NEWBIE";
}

Target SetTarget() {
    srand(time(NULL));
    Target target;
    target.CenterTarget.x = rand() % 801 - 400;
    target.CenterTarget.y = rand() % 801 - 400;
    target.r10 = 200;
    target.r5 = 400;
    target.r1 = 600;
    return target;
};


Coord Interference(Coord p)
{
    srand(time(NULL));
    p.x += rand() % 21 - 10;
    p.y += rand() % 21 - 10;
    return (p);
};


int ShotResult(Coord p1, Target t1)
{
    int res = 0;
    double dev = sqrt(pow((p1.x - t1.CenterTarget.x), 2) + pow((p1.y - t1.CenterTarget.y), 2));
    if (dev <= t1.r10) res = 10;
    else if (dev <= t1.r5) res = 5;
    else if (dev <= t1.r1) res = 1;
    return (res);
};



int main()
{
    Target target = SetTarget();
    Coord shot;
    int i=0, TotalResult=0;
    do {
        cout << "\nInput x coordinate of " << i + 1 << " shot between - 1000 and 1000: \n";
        cin >> shot.x;
        cout << "\nInput y coordinate of " << i + 1 << " shot between - 1000 and 1000: \n";
        cin >> shot.y;
        shot = Interference(shot);
        cout << "Shot with interference: "<< "x = " << shot.x << " " << "y = " << shot.y << " result: " << ShotResult(shot, target) << " points \n";
        TotalResult += ShotResult(shot, target);
        cout << "Total result: " << TotalResult << " points \n";
        i++;
    }
    while (TotalResult < 50);
    cout << "Congratulations, your total result: " << TotalResult << " points, for "<< i <<" shots \n";
    cout << "Your level is: " << ShooterLevel(i) << endl;
    return 0;
    
};