# Gym Management

Spring Boot project for the DS1 (Développement Web) at ESPRIT.

It is a REST API to manage a gym: members, coaches, plans, sessions, subscriptions and bookings.

## Team

| Name | Part |
|---|---|
| Chames Daboussi | Project setup, Coach, Session |
| Chiraz Belguith | Member |
| Rabeb | Plan |
| Arij Belhaj | Subscription |
| Rahma Ben Ameur | Booking |

## Technologies

- Java 25
- Spring Boot
- Spring Data JPA
- MySQL
- Validation
- Postman

## Entities

- **Member**: fullName, age, email, phone
- **Coach**: fullName, phone, specialty (FITNESS, YOGA, BOXING, CARDIO, CROSSFIT)
- **Plan**: name, price, durationInDays
- **Session**: title, date, capacity
- **Subscription**: startDate, endDate
- **Booking**: bookingDate

Relations:
- A coach has many sessions
- A member has many subscriptions and many bookings
- A plan has many subscriptions
- A session has many bookings

## Business rules

- The end date of a subscription is calculated automatically (start date + plan duration).
- A member can't book the same session twice.
- A session can't be booked when it is full.

## Endpoints

### Member

| Method | URL | Description |
|---|---|---|
| GET | `/api/members` | Get all members |
| GET | `/api/members/{id}` | Get a member |
| POST | `/api/members` | Add a member |
| PUT | `/api/members/{id}` | Update a member |
| DELETE | `/api/members/{id}` | Delete a member |

### Coach

| Method | URL | Description |
|---|---|---|
| GET | `/api/coaches` | Get all coaches |
| GET | `/api/coaches/{id}` | Get a coach |
| GET | `/api/coaches/specialty/{specialty}` | Get coaches by specialty |
| POST | `/api/coaches` | Add a coach |
| PUT | `/api/coaches/{id}` | Update a coach |
| DELETE | `/api/coaches/{id}` | Delete a coach |

### Plan

| Method | URL | Description |
|---|---|---|
| GET | `/api/plans` | Get all plans |
| GET | `/api/plans/{id}` | Get a plan |
| POST | `/api/plans` | Add a plan |
| PUT | `/api/plans/{id}` | Update a plan |
| DELETE | `/api/plans/{id}` | Delete a plan |

### Session

| Method | URL | Description |
|---|---|---|
| GET | `/api/sessions` | Get all sessions |
| GET | `/api/sessions/{id}` | Get a session |
| GET | `/api/sessions/coach/{coachId}` | Get sessions of a coach |
| POST | `/api/sessions/coach/{coachId}` | Add a session for a coach |
| PUT | `/api/sessions/{id}` | Update a session |
| DELETE | `/api/sessions/{id}` | Delete a session |

### Subscription

| Method | URL | Description |
|---|---|---|
| GET | `/api/subscriptions` | Get all subscriptions |
| GET | `/api/subscriptions/{id}` | Get a subscription |
| GET | `/api/subscriptions/expired` | Get expired subscriptions |
| POST | `/api/subscriptions/{memberId}/{planId}` | Subscribe a member to a plan |
| DELETE | `/api/subscriptions/{id}` | Delete a subscription |

### Booking

| Method | URL | Description |
|---|---|---|
| GET | `/api/bookings` | Get all bookings |
| GET | `/api/bookings/{id}` | Get a booking |
| GET | `/api/bookings/member/{memberId}/sessions` | Get sessions of a member |
| POST | `/api/bookings/{memberId}/{sessionId}` | Book a session |
| DELETE | `/api/bookings/{id}` | Delete a booking |

## How to run

1. Start MySQL.
2. Check the username and password in `src/main/resources/application.properties`.
3. Run the project in Spring Tools (Run As → Spring Boot App).
4. The database `gym_db` is created automatically.
5. The API runs on `http://localhost:8081`.

## Postman

Import the file `postman/Gym_Management_API.postman_collection.json` in Postman and run the folders in order.

## Screenshots

| Test | Screenshot |
|---|---|
| Add member | ![](screenshots/01-add-member.png) |
| Get all members | ![](screenshots/02-get-all-members.png) |
| Update member | ![](screenshots/03-update-member.png) |
| Add coach | ![](screenshots/04-add-coach.png) |
| Coaches by specialty | ![](screenshots/05-coaches-by-specialty.png) |
| Add plan | ![](screenshots/06-add-plan.png) |
| Add session | ![](screenshots/07-add-session.png) |
| Sessions of a coach | ![](screenshots/08-sessions-of-coach.png) |
| Add subscription | ![](screenshots/09-add-subscription.png) |
| Expired subscriptions | ![](screenshots/10-expired-subscriptions.png) |
| Add booking | ![](screenshots/11-add-booking.png) |
| Sessions of a member | ![](screenshots/12-sessions-of-member.png) |
| Delete member | ![](screenshots/13-delete-member.png) |
| Error: member not found | ![](screenshots/14-member-not-found.png) |
| Error: invalid member | ![](screenshots/15-invalid-member.png) |
| Error: invalid plan | ![](screenshots/16-invalid-plan.png) |
| Error: session in the past | ![](screenshots/17-session-in-past.png) |
| Error: coach not found | ![](screenshots/18-coach-not-found.png) |
| Error: already booked | ![](screenshots/19-already-booked.png) |
| Error: session is full | ![](screenshots/20-session-full.png) |
