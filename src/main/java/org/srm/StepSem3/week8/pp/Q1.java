from abc import ABC, abstractmethod

class Payment(ABC):
    def __init__(self, amount):
        self.amount = amount
    @abstractmethod
    def final_amount(self): ...

class Card(Payment):
    def final_amount(self): return self.amount * 1.02

class Wallet(Payment):
    def final_amount(self): return self.amount * 1.01

class BankTransfer(Payment):
    def final_amount(self): return self.amount

TYPES = {"CARD": Card, "WALLET": Wallet, "BANKTRANSFER": BankTransfer}

n = int(input())
total = 0
for _ in range(n):
    t, amt = input().split()
    p = TYPES[t](float(amt))
    res = p.final_amount()
    total += res
    print(f"{t}: {res:.2f}")
print(f"Total: {total:.2f}")