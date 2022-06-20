#include <iostream>
using std::endl;
using std::cout;
using std::cin;
using std::string;
int rub[5] = { 25,10,5,2,1 };
int kop[4] = { 50,10,5,1 };

void CoinsExchange(int r, int k)
{
	int s, i;
	i = 0;
	while (r > 0) {
		s = r / rub[i];
		if (s > 0) {
			r = (r - s * rub[i]);
			cout << "\n" << s << " coins denomination of " << rub[i] << " rub " << endl;
		}
		i++;
	}
	i = 0;
	while (k > 0) {
		s = k / kop[i];
		if (s > 0) {
			k = (k - s * kop[i]);
			cout << "\n" << s << " coins denomination of " << kop[i] << " kop " << endl;
		}
		i++;
	}

}

int main()
{
	int r,k;
	cout << "\nInput sum in rubles and kopecks:\n";
	cin >> r;
	cin >> k;
	CoinsExchange(r,k);
	return 0;
}