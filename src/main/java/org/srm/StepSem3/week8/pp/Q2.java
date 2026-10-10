import shlex
from abc import ABC, abstractmethod
from datetime import date, timedelta

TODAY = date(2023, 10, 26)

class Item(ABC):
    def __init__(self, title):
        self.title = title
    @abstractmethod
    def days(self): ...
    def due_date(self):
        return TODAY + timedelta(days=self.days())

class Book(Item):
    def days(self): return 14

class DVD(Item):
    def days(self): return 7

class Magazine(Item):
    def days(self): return 3

TYPES = {"BOOK": Book, "DVD": DVD, "MAGAZINE": Magazine}

n = int(input())
for _ in range(n):
    parts = shlex.split(input())   # handles the quotes around titles
    item = TYPES[parts[0]](parts[1])
    print(f"{item.title}: {item.due_date().strftime('%Y-%m-%d')}")