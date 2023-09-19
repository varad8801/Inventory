let productsPerPage = 100;
let currentPage = 1;
let allProductsData; // Store all product data globally

function filterProducts(query) {
    return allProductsData.filter(product => {
        const productName = product.productName ? product.productName.toLowerCase() : '';
        const category = product.category ? product.category.toLowerCase() : '';
        const subCategory = product.subCategory ? product.subCategory.toLowerCase() : '';
        const brand = product.brand ? product.brand.toLowerCase() : '';

        return (
            productName.includes(query.toLowerCase()) ||
            category.includes(query.toLowerCase()) ||
            subCategory.includes(query.toLowerCase()) ||
            brand.includes(query.toLowerCase())
        );
    });
}


function displayProducts(data) {
    const startIdx = (currentPage - 1) * productsPerPage;
    const endIdx = startIdx + productsPerPage;

    const productsToDisplay = data.slice(startIdx, endIdx);

    const productTableBody = document.getElementById('productTableBody');
    productTableBody.innerHTML = '';

    productsToDisplay.forEach(product => {
        const productRow = `
            <tr>
                <td>${product.productId}</td>
                <td>${product.productName}</td>
                <td>${product.category}</td>
                <td>${product.subCategory}</td>
                <td>${product.productWeight}</td>
                <td>${product.brand}</td>
            </tr>
        `;
        productTableBody.innerHTML += productRow;
    });
}

function updatePagination(data) {
    const totalPages = Math.ceil(data.length / productsPerPage);

    const paginationElement = document.getElementById('pagination');
    paginationElement.innerHTML = '';

    for (let i = 1; i <= totalPages; i++) {
        const li = document.createElement('li');
        li.classList.add('page-item');

        const a = document.createElement('a');
        a.classList.add('page-link');
        a.href = '#';
        a.innerText = i;

        a.addEventListener('click', function() {
            currentPage = i;
            displayProducts(data);
        });

        li.appendChild(a);
        paginationElement.appendChild(li);
    }
}

function performSearch() {
    const query = document.getElementById('searchInput').value.trim();

    if (query === '') {
		
        window.location.reload();
    } else {
        const filteredProducts = filterProducts(query);
        updatePagination(filteredProducts);
        displayProducts(filteredProducts);
    }
}



document.addEventListener('DOMContentLoaded', function() {
    // Make a GET request to fetch products
    fetch('http://localhost:8080/products/getallProducts')
        .then(response => response.json())
        .then(data => {
            allProductsData = data; // Store all product data globally
            updatePagination(data);
            displayProducts(data);
        })
        .catch(error => console.error('Error:', error));
});

const searchButton = document.getElementById('searchButton');
searchButton.addEventListener('click', performSearch);

const searchInput = document.getElementById('searchInput');
searchInput.addEventListener('keyup', function(event) {
    if (event.key === 'Enter') {
        performSearch();
    }
});
