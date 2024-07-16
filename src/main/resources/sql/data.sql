insert into USERS (ID, PASSWORD, USERNAME, ENABLED)
VALUES (0, '', 'anonymous', true);
insert into USERS (ID, PASSWORD, USERNAME, ENABLED)
VALUES (1, '$2a$06$OAPObzhRdRXBCbk7Hj/ot.jY3zPwR8n7/mfLtKIgTzdJa4.6TwsIm', 'admin', true);
insert into USERS (ID, PASSWORD, USERNAME, ENABLED)
VALUES (2, '$2a$06$OAPObzhRdRXBCbk7Hj/ot.jY3zPwR8n7/mfLtKIgTzdJa4.6TwsIm', 'user', true);

insert into AUTHORITIES (ID, AUTHORITY)
VALUES (0, 'ROLE_ANONYMOUS');
insert into AUTHORITIES (ID, AUTHORITY)
VALUES (1, 'ROLE_ADMIN');
insert into AUTHORITIES (ID, AUTHORITY)
VALUES (2, 'ROLE_USER');

insert into USERS_AUTHORITIES (USER_ID, AUTHORITY_ID)
VALUES (1, 1);
insert into USERS_AUTHORITIES (USER_ID, AUTHORITY_ID)
VALUES (1, 2);
insert into USERS_AUTHORITIES (USER_ID, AUTHORITY_ID)
VALUES (2, 2);

insert into POSTS (ID, BODY, CREATION_DATE, TITLE, USER_ID)
VALUES (1, 'Traveling solo can be one of the most liberating and enriching experiences of your life. Whether you’re an experienced wanderer or a first-time adventurer, solo travel offers a unique opportunity to discover not only the world but also yourself. Here’s your ultimate guide to making the most of your solo travel journey.

1. Planning Your Trip
Choose Your Destination Wisely: Start with destinations known for being solo traveler-friendly. Think about the safety, cultural attractions, and ease of getting around. Cities like Tokyo, Amsterdam, and Melbourne are great for solo travelers.

Create a Flexible Itinerary: While it’s good to have a plan, don’t be afraid to leave some room for spontaneous adventures. Flexibility allows you to follow your interests as they develop.

Book Accommodations in Advance: Secure your first few nights’ accommodation before you leave. Hostels, guesthouses, and Airbnb are excellent options for meeting other travelers.

2. Staying Safe on the Road
Keep Your Valuables Secure: Use money belts, anti-theft backpacks, and hotel safes to keep your valuables protected. Always have a backup of important documents like your passport and travel insurance.

Stay Connected: Keep friends and family informed of your whereabouts. Share your itinerary and check in regularly via messaging apps or social media.

Trust Your Instincts: If something feels off, trust your gut and remove yourself from the situation. It’s better to be safe and cautious.

3. Making the Most of Your Experience
Meet New People: Join group tours, attend local events, and stay in communal accommodations to meet fellow travelers. Websites like Meetup and Couchsurfing can also help you connect with locals.

Immerse Yourself in the Culture: Learn a few phrases in the local language, try local cuisine, and participate in cultural activities. This deepens your connection with the place you’re visiting.

Document Your Journey: Keep a travel journal, take lots of photos, and consider starting a blog or Instagram page to share your experiences.',
        '2024-01-10', 'The Ultimate Guide to Solo Travel: Tips and Tricks for the Adventurous Explorer', 2);
insert into POSTS (ID, BODY, CREATION_DATE, TITLE, USER_ID)
VALUES (2, 'Traveling with children can be a wonderful way to bond and create lasting memories, but it can also be challenging. Here’s how to ensure your family vacation is as enjoyable and stress-free as possible.

1. Choosing the Right Destination
Family-Friendly Locations: Opt for destinations with plenty of kid-friendly activities and amenities. Theme parks, beach resorts, and national parks are great choices.

Consider Travel Time: Long flights and layovers can be tough on kids. Choose destinations with shorter travel times or direct flights if possible.

Check for Child Discounts: Many attractions, accommodations, and transport options offer discounts for children. Research these in advance to save money.

2. Packing Essentials for Kids
Travel Documents: Ensure all necessary documents, such as passports and visas, are up to date. Carry copies in case of loss.

Entertainment and Comfort: Pack plenty of snacks, toys, and games to keep your kids entertained. Bring comfort items like blankets or stuffed animals to help them feel at home.

Health and Safety: Include a first aid kit with essentials like band-aids, antiseptic wipes, and any prescription medications. Don’t forget sunscreen and insect repellent.

3. Managing Travel Days
Early Arrival: Arrive at the airport or train station early to allow time for check-in, security, and any unexpected delays.

Keep Essentials Handy: Have a backpack or carry-on with all your travel essentials, including snacks, water, diapers, and entertainment for the kids.

Stay Calm and Flexible: Travel can be unpredictable. Stay calm and be flexible if plans change. Kids will follow your lead, so maintaining a positive attitude helps everyone stay relaxed.

4. Enjoying Your Destination
Plan Activities for All Ages: Balance your itinerary with activities that cater to both kids and adults. Consider half-day excursions so that children don’t get overwhelmed.

Take Breaks: Allow for downtime and naps. Kids (and adults) need rest to enjoy the vacation fully.

Capture the Moments: Take plenty of photos and encourage your kids to keep a travel journal. These memories will be cherished for years to come.',
        '2023-02-20', 'Family Travel Made Easy: How to Plan a Stress-Free Vacation with Kids', 1);
insert into POSTS (ID, BODY, CREATION_DATE, TITLE, USER_ID)
VALUES (3, 'Traveling sustainably is not just a trend but a necessity. As travelers, we have a responsibility to protect the places we visit. Here’s how you can minimize your environmental impact and travel more sustainably.

1. Choosing Sustainable Destinations
Eco-Certified Locations: Look for destinations and accommodations with eco-certifications. These places are committed to sustainable practices and reducing their environmental footprint.

Off-the-Beaten-Path: Consider visiting less touristy locations. This helps reduce overtourism and supports local economies that are often overlooked.

Support Local Businesses: Choose locally-owned accommodations, restaurants, and tour operators. This ensures your money goes directly into the local economy.

2. Reducing Your Carbon Footprint
Fly Less, Travel Slow: Air travel has a significant carbon footprint. Whenever possible, opt for trains, buses, or carpooling. If you must fly, consider offsetting your carbon emissions.

Pack Light: Lighter luggage means less fuel consumption. Pack only what you need and choose eco-friendly products.

Sustainable Transport: Use public transportation, bike, or walk to explore your destination. Not only is it better for the environment, but it also allows you to experience the place more authentically.

3. Eco-Friendly Accommodation and Activities
Green Hotels: Stay in hotels that prioritize sustainability through energy efficiency, water conservation, and waste reduction.

Eco-Tours: Choose tours and activities that emphasize environmental education and conservation. Avoid activities that exploit wildlife or harm natural habitats.

Leave No Trace: Practice the Leave No Trace principles. Dispose of waste properly, minimize your impact on natural environments, and respect wildlife.

4. Mindful Consumption
Say No to Single-Use Plastics: Bring a reusable water bottle, shopping bag, and utensils. Avoid products wrapped in excessive packaging.

Eat Local and Plant-Based: Eating locally-sourced and plant-based meals reduces your carbon footprint. It’s also a great way to experience local cuisine.

Responsible Souvenirs: Choose souvenirs that are made sustainably and ethically. Avoid products made from endangered species or unsustainable materials.

Traveling sustainably doesn’t mean sacrificing comfort or enjoyment. By making mindful choices, you can protect the planet while exploring its wonders. Happy eco-friendly travels!',
        '2022-03-30', 'Eco-Friendly Travel: How to Explore the World Sustainably', 2);

insert into COMMENTS (ID, BODY, CREATION_DATE, POST_ID, USER_ID)
VALUES (1, 'comentras a', current_timestamp(), 1, 0);
insert into COMMENTS (ID, BODY, CREATION_DATE, POST_ID, USER_ID)
VALUES (2, 'comentras a', current_timestamp(), 1, 2);
insert into COMMENTS (ID, BODY, CREATION_DATE, POST_ID, USER_ID)
VALUES (3, 'comentras a', current_timestamp(), 1, 0);
insert into COMMENTS (ID, BODY, CREATION_DATE, POST_ID, USER_ID)
VALUES (4, 'comentras a', current_timestamp(), 2, 0);
insert into COMMENTS (ID, BODY, CREATION_DATE, POST_ID, USER_ID)
VALUES (5, 'comentras a', current_timestamp(), 2, 1);
insert into COMMENTS (ID, BODY, CREATION_DATE, POST_ID, USER_ID)
VALUES (6, 'comentras a', current_timestamp(), 1, 0);


