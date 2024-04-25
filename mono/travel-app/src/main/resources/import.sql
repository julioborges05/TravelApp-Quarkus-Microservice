INSERT INTO TravelOrder(id) VALUES (nextval('travel_order_sequence'));
INSERT INTO TravelOrder(id) VALUES (nextval('travel_order_sequence'));
INSERT INTO TravelOrder(id) VALUES (nextval('travel_order_sequence'));
INSERT INTO TravelOrder(id) VALUES (nextval('travel_order_sequence'));

------------------------------------------------------------------------

INSERT INTO Hotel(id, travelOrderId, nights) VALUES (nextval('hotel_sequence'), 1, 5);
INSERT INTO Hotel(id, travelOrderId, nights) VALUES (nextval('hotel_sequence'), 2, 15);
INSERT INTO Hotel(id, travelOrderId, nights) VALUES (nextval('hotel_sequence'), 3, 25);
INSERT INTO Hotel(id, travelOrderId, nights) VALUES (nextval('hotel_sequence'), 4, 35);

------------------------------------------------------------------------

INSERT INTO Flight(id,travelOrderId,fromAirport,toAirport) VALUES (nextval('flight_sequence'),1,'GRU','MCO');
INSERT INTO Flight(id,travelOrderId,fromAirport,toAirport) VALUES (nextval('flight_sequence'),2,'GRU','JFK');
INSERT INTO Flight(id,travelOrderId,fromAirport,toAirport) VALUES (nextval('flight_sequence'),3,'GRU','ATL');
INSERT INTO Flight(id,travelOrderId,fromAirport,toAirport) VALUES (nextval('flight_sequence'),4,'GRU','MEX');