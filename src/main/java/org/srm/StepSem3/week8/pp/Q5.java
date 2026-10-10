from abc import ABC, abstractmethod

class Journey(ABC):
    def __init__(self, distance, factor=1.0):
        self.distance = distance
        self.factor = factor
    @abstractmethod
    def fare(self): ...

class Bus(Journey):
    def fare(self): return min(2 + 0.10 * self.distance, 10)

class Train(Journey):
    def fare(self): return 3 + 0.15 * self.distance

class Metro(Journey):
    def fare(self): return (1.5 + 0.20 * self.distance) * self.factor

TYPES = {"BUS": Bus, "TRAIN": Train, "METRO": Metro}

n = int(input())
total = 0
for _ in range(n):
    parts = input().split()
    args = [float(x) for x in parts[1:]]
    j = TYPES[parts[0]](*args)
    f = j.fare()
    total += f
    print(f"{parts[0]}: {f:.2f}")
print(f"Total: {total:.2f}")