Shopping App
This is a simple shopping web application developed using Java and the Spring Framework. It allows users to perform various actions such as ordering products, applying coupons, making payments, and viewing order statuses.

Features
Users can enter the quantity of products they want to order.
The app checks if the desired quantity of the product is available.
Users can check available coupons and apply one if valid. Each coupon can only be applied once per user.
Users can make payments for their orders.
Users can view the status of all their orders.
Installation
To run the application locally, follow these steps:

Clone this repository to your local machine.
Ensure you have Java and Maven installed.
Navigate to the project directory.
Run mvn spring-boot:run to start the application.
Access the application at http://localhost:8080.
Usage
Upon accessing the application, users will be able to perform the actions described above through the provided endpoints.
The application provides responses in JSON format for every user action.
Configuration
The app assumes there is only one type of product with a fixed quantity, which can be fetched from a config file during startup.
You may customize the product details and other configurations in the application.properties file.
API Endpoints
GET /inventory

Retrieves information about product inventory.
Provides details such as ordered quantity, price, and availability.
GET /fetchCoupons

Fetches available coupons along with their discount percentages.
POST /{userId}/order?qty={quantity}&coupon={couponCode}

Places an order for the specified user with the given quantity and coupon code.
Returns information about the order, including the order ID and amount.
POST /{userId}/{orderId}/pay?amount={paymentAmount}

Makes a payment for the specified order with the given payment amount.
Returns the payment transaction status.
GET /{userId}/orders

Retrieves all orders placed by the specified user.
Provides details such as order ID, amount, date, and applied coupon.
GET /{userId}/orders/{orderId}

Retrieves the details of a specific order placed by the user.
Provides information about the order, including its status and transaction ID.
