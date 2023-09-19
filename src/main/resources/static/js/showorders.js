let ordersPerPage = 10;
let currentOrderPage = 1;
let allOrdersData;

function filterOrders(query) {
    return allOrdersData.filter(order => {
        const orderName = order.orderName ? order.orderName.toLowerCase() : '';
        return orderName.includes(query.toLowerCase());
    });
}

function displayOrders(data) {
    const startIdx = (currentOrderPage - 1) * ordersPerPage;
    const endIdx = startIdx + ordersPerPage;

    const ordersToDisplay = data.slice(startIdx, endIdx);

    const orderTableBody = document.getElementById('orderTableBody');
    orderTableBody.innerHTML = '';

    ordersToDisplay.forEach(order => {
        const orderRow = `
            <tr>
                <td>${order.orderId}</td>
                <td>${order.orderName}</td>
                <td>${order.orderDate}</td>
                
            </tr>
        `;
        orderTableBody.innerHTML += orderRow;
    });
}

function updatePagination(data) {
    const totalPages = Math.ceil(data.length / ordersPerPage);

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
            currentOrderPage = i;
            displayOrders(data);
        });

        li.appendChild(a);
        paginationElement.appendChild(li);
    }
}

function performSearch() {
    const query = document.getElementById('searchInput').value.trim();

    if (query === '') {
        displayOrders(allOrdersData);
        updatePagination(allOrdersData);
    } else {
        const filteredOrders = filterOrders(query);
        displayOrders(filteredOrders);
        updatePagination(filteredOrders);
    }
}

document.addEventListener('DOMContentLoaded', function() {
    // Make a GET request to fetch orders
    fetch('http://localhost:8080/order/getAll')
        .then(response => response.json())
        .then(data => {
            allOrdersData = data;
            displayOrders(data);
            updatePagination(data);
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
