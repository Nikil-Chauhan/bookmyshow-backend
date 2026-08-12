# BMS Frontend - HTML, CSS and JavaScript

This is a pure frontend for the BookMyShow-style project.

## Technologies
- HTML5
- CSS3
- Vanilla JavaScript
- No React
- No Bootstrap
- No Tailwind

## Run
You can simply open `index.html` in a browser.

For a local server, from this folder run:

```bash
python3 -m http.server 5500
```

Then open:
http://localhost:5500

## Pages
- Home
- Movies
- Movie details
- Show selection
- Seat selection
- Checkout
- Booking confirmation
- My bookings
- Login
- Register

## Connecting to Spring Boot
The current UI uses demo data in `js/app.js`.

Your Spring Boot backend can later replace the demo arrays with `fetch()` calls such as:

```js
fetch("http://localhost:8080/movies")
  .then(response => response.json())
  .then(data => console.log(data));
```

Make sure your Spring Boot application allows requests from the frontend (CORS).
