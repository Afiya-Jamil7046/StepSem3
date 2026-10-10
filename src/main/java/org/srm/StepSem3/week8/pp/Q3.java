from abc import ABC, abstractmethod

class Delivery(ABC):
    def __init__(self, weight, distance, extra=0):
        self.weight = weight
        self.distance = distance
        self.extra = extra
    @abstractmethod
    def fee(self): ...

class Standard(Delivery):
    def fee(self): return 5 + 0.50 * self.weight + 0.10 * self.distance

class Express(Delivery):
    def fee(self): return 15 + 1.00 * self.weight + 0.20 * self.distance

class International(Delivery):
    def fee(self):
        return 25 + 2.00 * self.weight + 0.50 * self.distance + self.extra

TYPES = {"STANDARD": Standard, "EXPRESS": Express, "INTERNATIONAL": International}

n = int(input())
total = 0
for _ in range(n):
    parts = input().split()
    args = [float(x) for x in parts[1:]]   # weight, distance, [customs]
    d = TYPES[parts[0]](*args)
    f = d.fee()
    total += f
    print(f"{parts[0]}: {f:.2f}")
print(f"Total: {total:.2f}")