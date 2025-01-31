package cr.ac.utn.appmovil.model

import cr.ac.utn.appmovil.data.MemoryManager
import cr.ac.utn.appmovil.identities.bib_Reservation
import cr.ac.utn.appmovil.interfaces.IDBManager

class bib_ReservationModel {
    private val dbManager: IDBManager = MemoryManager

    fun addReservation(reservation: bib_Reservation) {
        dbManager.add(reservation)
    }

    fun updateReservation(reservation: bib_Reservation) {
        dbManager.update(reservation)
    }

    fun removeReservation(id: String) {
        dbManager.remove(id)
    }

    fun getReservations(): List<bib_Reservation> {
        return dbManager.getAll().filterIsInstance<bib_Reservation>()
    }

    fun getReservation(id: String): bib_Reservation? {
        return dbManager.getByid(id) as? bib_Reservation
    }

    fun getReservationsByStudentName(studentName: String): List<bib_Reservation> {
        return dbManager.getAll().filterIsInstance<bib_Reservation>().filter { it.StudentName == studentName }
    }

    fun getReservationNames(): List<String> {
        return getReservations().map { it.BookName }
    }
}
