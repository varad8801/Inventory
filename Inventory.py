from faker import Faker
import json
import random

fake = Faker()

def generate_product():
    return {
        # Unique product ID
        "productName": fake.company(),
        "category": fake.word(),
        "subCategory": fake.word(),
        "productWeight": f"{fake.random_int(1, 100) / 100:.2f} kg",
        "brand": fake.company(),
        "pricing": {
            "unitPrice": round(random.uniform(50, 1000), 2),
            "costPrice": round(random.uniform(10, 500), 2)
        },
        "stock": {
            "quantity": random.randint(1, 500),
            "minimumQuantity": random.randint(1, 50),
            "maximumQuantity": random.randint(100, 1000),
            "reorderPoint": random.randint(10, 100),
            "supplierInfo": fake.company(),
            "barcode": fake.ean13(),
            "location": fake.random_element(["Aisle 1", "Aisle 2", "Aisle 3"]),
            "expirationDate": fake.future_date(end_date="+2y").strftime("%Y-%m-%d"),
            "manufacturingDate": fake.past_date(start_date="-1y").strftime("%Y-%m-%d"),
            "notes": fake.sentence(),
            "weight": f"{fake.random_int(100, 500) / 100:.2f}"
        }
    }

products = [generate_product() for _ in range(1000)]  # Generate 200 products

with open("products.json", "w") as outfile:
    json.dump(products, outfile, indent=2)

print("products.json has been generated with 200 product instances.")
