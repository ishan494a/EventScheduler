# EventScheduler

**Status: Under Progress**

EventScheduler is a Spring Boot application designed to help users manage and schedule events efficiently. The application leverages OAuth2 for authentication and integrates with a PostgreSQL database for data persistence.

## Features

- User authentication using OAuth2
- Event scheduling and management
- User-specific event data storage
- Responsive web interface

## Optimization with Data Structures and Algorithms

To enhance the performance and efficiency of the EventScheduler, the following data structures will be utilized:

- **Prefix Trie**: 
  - Used for efficient string matching and autocomplete features when searching for events by name or description. This allows for faster and more responsive search capabilities.

- **Segment Tree**: 
  - This will be implemented to efficiently manage and query range-based event data, such as finding all events occurring within a specific time frame. This is particularly useful for displaying events in a calendar view.

- **Binary Search Tree (BST)**: 
  - A BST will be used for maintaining an ordered collection of events, allowing for efficient insertion, deletion, and lookup operations. This can facilitate operations like finding the next upcoming event or managing overlapping events.
  
## Technologies Used
- **Frontend**: React,js
- **Backend**: Spring Boot
- **Database**: PostgreSQL
- **Security**: Spring Security with OAuth2
- **Build Tool**: Maven

## Contributing

Contributions are welcome! Please feel free to open issues or submit pull requests.

