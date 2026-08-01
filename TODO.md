# Fix Plan - Package Errors & Type Issues

## ✅ Completed Steps

- [x] 1. Fix `repository/CustomerRepository.java` - Added `package Food_Delivery.repository;`
- [x] 2. Fix `repository/RestaurantRepository.java` - Added `package Food_Delivery.repository;`
- [x] 3. Fix `Restaurant.java` - Changed `removeMenuItem(int)` to `removeMenuItem(long)`
- [x] 4. Fix `MenuServiceImpl.java` - Removed `(int)` cast in `removeMenuItem` call
- [x] 5. Fix `Cart.java` - Fixed `Long` object comparisons using `.longValue()` in `addItemToCart` and `removeItem`
- [x] 6. Fix `Customer.java` - Added `password` parameter to constructor
