INSERT INTO TravelOrder(id) VALUES (nextval('travel_order_sequence'));
INSERT INTO TravelOrder(id) VALUES (nextval('travel_order_sequence'));
INSERT INTO TravelOrder(id) VALUES (nextval('travel_order_sequence'));
INSERT INTO TravelOrder(id) VALUES (nextval('travel_order_sequence'));
INSERT INTO TravelOrder(id) VALUES (nextval('travel_order_sequence'));

------------------------------------------------------------------------

INSERT INTO Hotel(id, travelOrderId, nights) VALUES (nextval('hotel_sequence'), 1, 5);
INSERT INTO Hotel(id, travelOrderId, nights) VALUES (nextval('hotel_sequence'), 2, 15);
INSERT INTO Hotel(id, travelOrderId, nights) VALUES (nextval('hotel_sequence'), 3, 25);
INSERT INTO Hotel(id, travelOrderId, nights) VALUES (nextval('hotel_sequence'), 4, 35);
INSERT INTO Hotel(id, travelOrderId, nights) VALUES (nextval('hotel_sequence'), 5, 45);