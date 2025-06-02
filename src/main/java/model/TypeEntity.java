package model;
import jakarta.persistence.*;

@Entity
@Table(name = "type_entity")
public class TypeEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;

        @ManyToOne
        @JoinColumn(name = "public_holiday_id")
        private PublicHolidayEntity publicHoliday;

        public TypeEntity() {}

        public TypeEntity(String name) {
            this.name = name;
        }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public PublicHolidayEntity getPublicHoliday() {
			return publicHoliday;
		}

		public void setPublicHoliday(PublicHolidayEntity publicHoliday) {
			this.publicHoliday = publicHoliday;
		}

       
    }


