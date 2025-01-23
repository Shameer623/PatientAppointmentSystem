// Register Patient
document.getElementById('registerForm').addEventListener('submit', async (e) => {
    e.preventDefault();
    const formData = {
        firstname: document.getElementById('firstname').value,
        lastname: document.getElementById('lastname').value,
        contact: document.getElementById('contact').value
    };

    const response = await fetch('/patients/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(formData)
    });

    const result = await response.text();
    document.getElementById('responseMessage').textContent = result;
});

// Book Appointment
document.getElementById('appointmentForm').addEventListener('submit', async (e) => {
    e.preventDefault();
    const formData = {
        doctorName: document.getElementById('doctorName').value,
        specialization: document.getElementById('specialization').value,
        appointmentTime: document.getElementById('appointmentTime').value
    };

    const response = await fetch('/appointments/book', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(formData)
    });

    const result = await response.text();
    document.getElementById('appointmentResponse').textContent = result;
});