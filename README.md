# 🍔 FoodKart — SOLID Principles

Live refactoring of a food ordering service, one principle at a time.

## Branch structure

```
main            → README only
1-srp/before    → God class: OrderService does everything (~80 lines, 6 reasons to change)
1-srp/after     → SRP applied: each class has exactly one job
```

## How to read this

Checkout `1-srp/before` first. Count how many reasons `OrderService` has to change.  
Then checkout `1-srp/after`. The answer becomes 1.

---

## Principles covered

| # | Principle | Branch prefix |
|---|-----------|---------------|
| 1 | Single Responsibility (SRP) | `1-srp/` |
| 2 | Open/Closed (OCP)           | `2-ocp/` |
| 3 | Liskov Substitution (LSP)   | `3-lsp/` |
| 4 | Interface Segregation (ISP) | `4-isp/` |
| 5 | Dependency Inversion (DIP)  | `5-dip/` |