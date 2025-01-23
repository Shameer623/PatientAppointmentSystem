// Fetch All Appointments
async function fetchAppointments() {
    const response = await fetch('/admin/appointments');
    const appointments = await response.json();
    const tableBody = document.getElementById('allAppointmentsTable').getElementsByTagName('tbody')[0];
    tableBody.innerHTML = '';

    appointments.forEach(appointment => {
        const row = tableBody.insertRow();
        row.insertCell().textContent = appointment.patientName;
        row.insertCell().textContent = appointment.doctorName;
        row.insertCell().textContent = appointment.specialization;
        row.insertCell().textContent = appointment.appointmentTime;
        row.insertCell().textContent = appointment.status;
    });
}

fetchAppointments();