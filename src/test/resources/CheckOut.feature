Feature: Checkout the cart
As a User
I need to be able to Check out my shopping cart
so that I can compelte my shopping

Scenario: successful checkout for a logged in user with cart having one item
Given user "vinaykris@gmail.com" has logged in
And has "Microsoft Lumia 640" mobile in the cart priced Rs "10000"
And Vat is "15" %
When user checks out the cart
Then confirmation of billing is generated with "Microsoft Lumia 640" mobile
And Total price is Rs "1150"
