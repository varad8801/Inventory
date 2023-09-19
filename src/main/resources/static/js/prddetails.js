// Add Product Form Submission
document.getElementById("addProductForm").addEventListener("submit", function (event) {
    event.preventDefault();
    const formData = new FormData(this);
    const productData = {};
    formData.forEach((value, key) => {
        productData[key] = value;
    });

    // Send a POST request to add a product
    fetch("/products/addProducts", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify([productData]),
    })
    .then(response => response.text())
    .then(message => alert(message))
    .catch(error => console.error(error));

    this.reset();
});

// Find Product by Name
document.getElementById("findProductForm").addEventListener("submit", function (event) {
    event.preventDefault(); // Prevent form submission

    const productName = document.getElementById("findProductName").value;

    // Send a GET request to find a product by name on the server
    fetch(`/products/findProductsByName?productName=${productName}`)
        .then(response => {
            if (!response.ok) {
               alert(response.status);
                
            }
            return response.json();
        })
        .then(product => {
            const foundProductInfo = document.getElementById("foundProductInfo");

            if (product) {
                const table = `
                    <h2>Found Product Information</h2>
                   <table class="styled-table">
                        <thead>
                            <tr>
                                <th>Property</th>
                                <th>Value</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Product ID</td>
                                <td>${product.productId || "N/A"}</td>
                            </tr>
                            <tr>
                                <td>Product Name</td>
                                <td>${product.productName || "N/A"}</td>
                            </tr>
                            <tr>
                                <td>Category</td>
                                <td>${product.category || "N/A"}</td>
                            </tr>
                            <tr>
                                <td>SubCategory</td>
                                <td>${product.subCategory || "N/A"}</td>
                            </tr>
                            <tr>
                                <td>Product Weight</td>
                                <td>${product.productWeight || "N/A"}</td>
                            </tr>
                            <tr>
                                <td>Brand</td>
                                <td>${product.brand || "N/A"}</td>
                            </tr>
                            <tr>
                                <td>Pricing</td>
                                <td>
                                    Unit Price: ${product.pricing?.unitPrice || "N/A"}<br>
                                    Cost Price: ${product.pricing?.costPrice || "N/A"}<br>
                                    Bulk Price: ${product.pricing?.bulkPrice || "N/A"}
                                </td>
                            </tr>
                            <tr>
                                <td>Stock</td>
                                <td>
                                    Quantity: ${product.stock?.quantity || "N/A"}<br>
                                    Minimum Quantity: ${product.stock?.minimumQuantity || "N/A"}<br>
                                    Maximum Quantity: ${product.stock?.maximumQuantity || "N/A"}<br>
                                    Reorder Point: ${product.stock?.reorderPoint || "N/A"}<br>
                                    Supplier Info: ${product.stock?.supplierInfo || "N/A"}<br>
                                    Barcode: ${product.stock?.barcode || "N/A"}<br>
                                    Location: ${product.stock?.location || "N/A"}<br>
                                    Expiration Date: ${product.stock?.expirationDate || "N/A"}<br>
                                    Manufacturing Date: ${product.stock?.manufacturingDate || "N/A"}<br>
                                    Notes: ${product.stock?.notes || "N/A"}<br>
                                    Weight: ${product.stock?.weight || "N/A"}<br>
                                    Length: ${product.stock?.length || "N/A"}<br>
                                    Width: ${product.stock?.width || "N/A"}<br>
                                    Height: ${product.stock?.height || "N/A"}
                                </td>
                            </tr>
                        </tbody>
                    </table>
                `;

                foundProductInfo.innerHTML = table;
            } else {
                foundProductInfo.innerHTML = "<p>Product not found.</p>";
            }
        })
        .catch(error => console.error(error));
});

// Update Product Form Submission
document.getElementById("updateProductForm").addEventListener("submit", function (event) {
    event.preventDefault();
    const formData = new FormData(this);
    const productData = {};
    formData.forEach((value, key) => {
        productData[key] = value;
    });

    // Send a PUT request to update a product
    fetch("/products/updateProducts", {
        method: "PUT",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify([productData]),
    })
    .then(response => response.text())
    .then(message => alert(message))
    .catch(error => console.error(error));

    this.reset();
});

// Delete Product by Name
function deleteProductByName() {
    const productName = document.getElementById("deleteProductName").value;
    
    // Send a DELETE request to delete a product by name
    fetch(`/products/deleteProducts?productName=${productName}`, {
        method: "DELETE",
    })
    .then(response => response.text())
    .then(message => alert(message))
    .catch(error => console.error(error));
}
