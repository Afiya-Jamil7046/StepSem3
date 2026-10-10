import shlex
from abc import ABC, abstractmethod

class Question(ABC):
    def __init__(self, text, correct, student, points):
        self.text = text
        self.correct = correct
        self.student = student
        self.points = points
    @abstractmethod
    def score(self): ...

class MCQ(Question):
    def score(self):
        return float(self.points) if self.student == self.correct else 0.0

class TF(Question):
    def score(self):
        return float(self.points) if self.student == self.correct else 0.0

class Essay(Question):
    def score(self):
        keys = [k.strip().lower() for k in self.correct.split(",") if k.strip()]
        ans = self.student.lower()
        hits = sum(1 for k in keys if k in ans)
        if hits >= 2: return self.points * 0.75
        if hits == 1: return self.points * 0.50
        return 0.0

TYPES = {"MCQ": MCQ, "TF": TF, "ESSAY": Essay}

n = int(input())
total = 0
for _ in range(n):
    p = shlex.split(input())
    q = TYPES[p[0]](p[1], p[2], p[3], int(p[4]))
    s = q.score()
    total += s
    print(f"{p[0]}: {s:.2f}")
print(f"Total Score: {total:.2f}")