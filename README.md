# Stripe Payment Service

This is a simple Spring Boot application that provides a REST API for processing payments using the Stripe payment gateway.

## Features
- Process payments using the Stripe API
- Create payment intents
- Handle webhook events from Stripe

## Technologies Used
- Java
- Spring Boot
- Spring Web
- Stripe Java library
- Maven

## How to Run
1. Clone this repository to your local machine
2. Configure your Stripe API keys in `application.properties`
3. Run the application using Maven: `mvn spring-boot:run`
4. Access the API at `http://localhost:8080`

## API Endpoints
- `POST /payment/intent`: Create a payment intent
- `POST /webhook`: Handle webhook events from Stripe

## Usage
1. Create a payment intent by sending a POST request to `/payment/intent` with the amount and currency.
2. Use the client secret from the response to confirm the payment on the frontend.
3. Handle webhook events from Stripe by implementing the logic in the `/webhook` endpoint.

## Sample Request Body for Creating a Payment Intent
```json
{
  "amount": 1000,
  "currency": "usd"
}
